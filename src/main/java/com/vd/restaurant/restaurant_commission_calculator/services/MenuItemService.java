package com.vd.restaurant.restaurant_commission_calculator.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vd.restaurant.restaurant_commission_calculator.entities.MenuItem;
import com.vd.restaurant.restaurant_commission_calculator.exceptions.MenuItemNotFoundException;
import com.vd.restaurant.restaurant_commission_calculator.repositories.MenuItemRepository;

@Service
public class MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public MenuItem addMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public Optional<MenuItem> getMenuItemById(Long id) {
        return menuItemRepository.findById(id);
    }

    public void deleteMenuItem(Long id) {
        if (!menuItemRepository.existsById(id)) {
            throw new MenuItemNotFoundException("Menu item with id " + id + " not found");
        }
        menuItemRepository.deleteById(id);
    }
}