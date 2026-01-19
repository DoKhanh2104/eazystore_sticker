package com.devithedev.eazystore.service.impl;

import java.time.Instant;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.devithedev.eazystore.dto.ContactDto;
import com.devithedev.eazystore.entity.Contact;
import com.devithedev.eazystore.repository.ContactRepository;
import com.devithedev.eazystore.service.IContactService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IContactService {

    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactDto contactDto) {
        Contact contact = transformEntity(contactDto);
        this.contactRepository.save(contact);
        return true;

    }

    private Contact transformEntity(ContactDto contactDto) {
        Contact contact = new Contact();
        BeanUtils.copyProperties(contactDto, contact);
        return contact;
    }

}
