package com.zy.storage.greendao;

import com.zy.common.app.AppUtils;
import com.zy.storage.greendao.entity.DaoMaster;
import com.zy.storage.greendao.entity.DaoSession;
import com.zy.storage.greendao.entity.TestEntity;
import com.zy.storage.greendao.entity.TestEntityDao;

/**
 * @author:zhangyue
 * @date:2020/4/25
 */
public class ZDaoManager {
    private static ZDaoManager instance=new ZDaoManager();
    private final DaoSession zz;

    private ZDaoManager(){
        zz = DaoMaster.newDevSession(AppUtils.getContext(), "zz");
    }

    public static ZDaoManager getInstance(){
        return instance;
    }

    public Long addTestEntity(TestEntity testEntity){

        TestEntityDao testEntityDao = zz.getTestEntityDao();
        long index = testEntityDao.insert(testEntity);
        return index;
    }

    public TestEntity getTestEntity(Long index){
        TestEntityDao testEntityDao = zz.getTestEntityDao();
        TestEntity testEntity = testEntityDao.load(index);
        return testEntity;
    }

}
