package com.bowen.myblog.service.Impl;

import com.bowen.myblog.Excepiton.NotFoundExcepiton;
import com.bowen.myblog.dao.TypeRepository;
import com.bowen.myblog.po.Type;
import com.bowen.myblog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ProjectName: MyBlog
 * @Package: com.bowen.myblog.service.Impl
 * @ClassName: TypeServiceImpl
 * @Author: Bowen
 * @Description: 分类业务实现
 * @Date: 2019/7/26 17:54
 * @Version: 1.0.0
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Transactional
    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findOne(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }


    @Override
    public List<Type> listTypeTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = PageRequest.of(0, size, sort);
        return typeRepository.findTop(pageable);
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) {
        Type t = typeRepository.findOne(id);
        if (t == null) {
            throw new NotFoundExcepiton("不存在该类型");
        }
        BeanUtils.copyProperties(type, t);
        return typeRepository.save(t);
    }


    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRepository.deleteOne(id);
    }
}
