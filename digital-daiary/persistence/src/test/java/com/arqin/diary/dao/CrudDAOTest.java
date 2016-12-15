package com.arqin.diary.dao;

import com.arqin.dairy.entity.Person;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by artemtursunov on 16.12.16.
 */
public class CrudDAOTest {

    @BeforeClass
    public static void init() {
        CrudDAO.init();
    }

    @Test
    public void addEntity() throws Exception {
        CrudDAO crud = new CrudDAO();
        Person p = new Person("Ivan", "Ivanov", "Ivanich");
        crud.addEntity(p);
    }

//    @Test
    public void updateEntity() throws Exception {

    }

//    @Test
    public void deleteEntity() throws Exception {

    }

//    @Test
    public void getEntity() throws Exception {

    }

}