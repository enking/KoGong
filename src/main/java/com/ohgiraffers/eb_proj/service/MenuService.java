package com.ohgiraffers.eb_proj.service;

import com.ohgiraffers.eb_proj.dto.MenuDTO;
import com.ohgiraffers.eb_proj.entity.Menu;
import com.ohgiraffers.eb_proj.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final ModelMapper mapper;
    private final MenuRepository menuRepository;

    public MenuDTO findMenuByMenuCode(int menuCode) {
        Menu selectedMenu = menuRepository.findById(menuCode).orElseThrow(IllegalArgumentException::new);
        return mapper.map(selectedMenu, MenuDTO.class);
    }
}
