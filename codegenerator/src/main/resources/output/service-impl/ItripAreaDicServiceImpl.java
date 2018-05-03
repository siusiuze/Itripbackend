package com.ytzl.itrip.service.impl;
import com.ytzl.itrip.biz.service.ItripAreaDicService;
import com.ytzl.itrip.dao.mapper.ItripAreaDicMapper;
import com.ytzl.itrip.beans.model.ItripAreaDic;
import com.ytzl.itrip.utils.common.EmptyUtils;
import com.ytzl.itrip.utils.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.ytzl.itrip.utils.common.Constants;

@Service("itripAreaDicService")
public class ItripAreaDicServiceImpl implements ItripAreaDicService {

    @Resource
    private ItripAreaDicMapper itripAreaDicMapper;

    public ItripAreaDic getItripAreaDicById(Long id)throws Exception{
        return itripAreaDicMapper.getItripAreaDicById(id);
    }

    public List<ItripAreaDic> getItripAreaDicListByMap(Map<String,Object> param)throws Exception{
        return itripAreaDicMapper.getItripAreaDicListByMap(param);
    }

    public Integer getItripAreaDicCountByMap(Map<String,Object> param)throws Exception{
        return itripAreaDicMapper.getItripAreaDicCountByMap(param);
    }

    public Integer saveItripAreaDic(ItripAreaDic itripAreaDic)throws Exception{
            itripAreaDic.setCreationDate(new Date());
            return itripAreaDicMapper.saveItripAreaDic(itripAreaDic);
    }

    public Integer modifyItripAreaDic(ItripAreaDic itripAreaDic)throws Exception{
        itripAreaDic.setModifyDate(new Date());
        return itripAreaDicMapper.modifyItripAreaDic(itripAreaDic);
    }

    public Integer removeItripAreaDicById(Long id)throws Exception{
        return itripAreaDicMapper.removeItripAreaDicById(id);
    }

    public Page<ItripAreaDic> queryItripAreaDicPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripAreaDicMapper.getItripAreaDicCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripAreaDic> itripAreaDicList = itripAreaDicMapper.getItripAreaDicListByMap(param);
        page.setRows(itripAreaDicList);
        return page;
    }

}
