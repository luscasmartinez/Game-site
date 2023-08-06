package com.rp3.marco4.domain.Users;

public record UserListData(Long id, String username, Category category) {

    public UserListData(User user){
        this(user.getId(), user.getUsername(), user.getCategory());
    }

}
