package com.sda.practicalproject1.repository;

import com.sda.practicalproject1.model.Consult;
import com.sda.practicalproject1.repository.base.RepositoryImpl;

public class ConsultRepositoryImpl extends RepositoryImpl<Consult> implements ConsultRepository {

    public ConsultRepositoryImpl() {
        super(Consult.class);
    }
}
