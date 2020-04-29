package com.bunny.starter.service;

import com.bunny.starter.beans.BunnyModel;
import com.bunny.starter.beans.CatModel;
import com.bunny.starter.beans.DogModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PanelService {

    @Autowired
    BunnyModel bunnyModel;

    @Autowired
    DogModel dogModel;

    @Autowired
    CatModel catModel;
}
