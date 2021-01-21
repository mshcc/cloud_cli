package com.mshcc.cloud.jwtuaa.service.impl;

import com.mshcc.cloud.jwtuaa.mapper.TPermissionMapper;
import com.mshcc.cloud.jwtuaa.model.GrantedAuthorityImpl;
import com.mshcc.cloud.jwtuaa.model.TPermission;
import com.mshcc.cloud.jwtuaa.service.TPermissionService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author mshcc
 * @Date 2021/1/6 11:25
 * @Description TODO
 */
@Service
public class TPermissionServiceImpl implements TPermissionService {

    @Resource
    private TPermissionMapper tPermissionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tPermissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TPermission record) {
        return tPermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(TPermission record) {
        return tPermissionMapper.insertSelective(record);
    }

    @Override
    public TPermission selectByPrimaryKey(Integer id) {
        return tPermissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TPermission record) {
        return tPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TPermission record) {
        return tPermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<GrantedAuthority> getPermissions(List<Integer> id) {
        if (id == null || id.size() == 0) {
            return new ArrayList<>();
        }
        List<TPermission> permissions = tPermissionMapper.getPermissionsByIds(id);
        List<GrantedAuthority> lists = new ArrayList<>();
        for (TPermission permission : permissions) {
            lists.add(new GrantedAuthorityImpl(permission.getCode()));
        }
        return lists;
    }

}
