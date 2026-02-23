package com.securin.cpeapi.service;

import com.securin.cpeapi.model.CpeEntity;
import com.securin.cpeapi.repository.CpeRepository;
import com.securin.cpeapi.xmlparser.XmlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class CpeService {

    private final CpeRepository repository;

    public CpeService(CpeRepository repository) {
        this.repository = repository;
    }

    public void loadXmlToDb() throws Exception {
        File file = new File("src/main/resources/cpe-dictionary.xml");
        List<CpeEntity> list = XmlParser.parse(file);
        repository.saveAll(list);
    }

    public Page<CpeEntity> getAll(int page, int limit) {
        return repository.findAll(PageRequest.of(page - 1, limit));
    }
}