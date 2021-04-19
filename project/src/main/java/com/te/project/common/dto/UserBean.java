package com.te.project.common.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserBean implements Serializable {
	private String username;
	private int password;
}
