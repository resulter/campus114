package com.thinkgem.jeesite.modules.act.service;


import com.thinkgem.jeesite.modules.act.dao.BaseDataMapper;
import com.thinkgem.jeesite.modules.act.dao.LsOfficeMapper;
import com.thinkgem.jeesite.modules.act.entity.*;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeSchoolService {



    @Autowired
    LsOfficeMapper lsOfficeMapper;

    /**
     * 查询所有校区
     *
     * @return
     */
    public List<LsOffice> getAll() {
        // TODO Auto-generated method stub
        return lsOfficeMapper.selectByExample(null);
    }

    public LsOffice getData(Integer id) {
        return lsOfficeMapper.selectByPrimaryKey(id);
    }
    /**
     * 校区保存
     *
     * @param lsOffice
     */
    public void saveData(LsOffice lsOffice) {
        // TODO Auto-generated method stub
        lsOfficeMapper.insert(lsOffice);
    }
    public int saveDataGetId(LsOffice lsOffice) {
        return lsOfficeMapper.insertAndGetId(lsOffice);
    }



    /**
     * 校区更新
     *
     * @param lsOffice
     */
    public void updateData(LsOffice lsOffice) {
        // TODO Auto-generated method stub
        lsOfficeMapper.updateByPrimaryKeySelective(lsOffice);
    }

    /**
     * 校区删除
     *
     * @param id
     */
    public void deleteData(Integer id) {
        // TODO Auto-generated method stub
        lsOfficeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        // TODO Auto-generated method stub
        LsOfficeExample example1 = new LsOfficeExample();
        LsOfficeExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andOIdIn(ids);
        lsOfficeMapper.deleteByExample(example1);
    }

    /**
     * 检验校区名是否可用
     *
     * @param name
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    public boolean checkName(String name) {
        // TODO Auto-generated method stub
        LsOfficeExample example1 = new LsOfficeExample();
        LsOfficeExample.Criteria criteria1 = example1.createCriteria();
        criteria1.andONameEqualTo(name);

        long count = lsOfficeMapper.countByExample(example1);
        return count == 0;
    }

    /**
     * 根据部门名称获取部门id
     * @param officeName
     * @return
     */
    public int getId(String officeName ){
        LsOfficeExample example = new LsOfficeExample();
        LsOfficeExample.Criteria criteria = example.createCriteria();
        criteria.andONameEqualTo(officeName);
        return  lsOfficeMapper.selectByExample(example).get(0).getoId();
    }

}
