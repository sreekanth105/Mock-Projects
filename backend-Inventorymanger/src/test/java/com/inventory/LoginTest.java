package com.inventory;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity.BodyBuilder;

import java.net.http.HttpResponse;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.format.Parser;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import org.hamcrest.Matchers;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.gson.Gson;
import com.inventory.controller.AdminController;
import com.inventory.entity.Admin;
import com.inventory.services.AdminService;

@SpringBootTest
//@RunWith(SpringRunner.class)
//@WebMvcTest(AdminController.class)
@AutoConfigureMockMvc
class LoginTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@MockBean
	AdminService service;

	@Autowired
	private MockMvc mockMvc;

//	@BeforeAll
//	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//	}
	@MockBean
	AdminController adminController;
	
//	@Test
//	void test() {
//		Admin admin = new Admin("Bhushan","b@123");		
//		assertEquals(withStatus(HttpStatus.OK),adminController.login(admin));
//	}
	@Test
	void testLogin() throws Exception {
		Admin admin = new Admin("Bhushan","b@123");
//		Mockito.when(adminController.login(admin)).thenReturn(ResponseEntity<admin>);
		doReturn(admin).when(service).getAdminByUsername("Bhushan");
		
//		Admin ad = ModelMapper.map(admin, Admin.class);
//        TestimonialsResponseDto testimonialsResponseDto = projectionFactory.createProjection(TestimonialsResponseDto.class, testimonialsCreationDto);
		mockMvc.perform(get("/admin/login/", new Gson().toJson(admin)))
		
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.ausername", is("Bhushan")))
        .andExpect(jsonPath("$.apassword", is("b@123")));
	}

}
