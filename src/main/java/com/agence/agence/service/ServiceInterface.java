package com.agence.agence.service;

import com.agence.agence.models.Agence;

import java.util.List;

public interface ServiceInterface<T>  {
   public T add(T t);
   public void delete(int t);
   public T update(T t);
   public T findById(Integer id);
   public List<T> list();


}
