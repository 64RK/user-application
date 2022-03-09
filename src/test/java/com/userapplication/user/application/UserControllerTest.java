package com.userapplication.user.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.controller.UserController;
import com.userapplication.user.application.repository.UserRepository;
import com.userapplication.user.application.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @InjectMocks  //@spy
    private UserController userController;


    User RECORD_1 = new User(1, "user1", 25, 6767, 77896);
    User RECORD_2 = new User(2, "user2", 56, 556767, 89876);

    @Test
    public void getAllUser() throws Exception {
        List<User> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));
        String expected = "[{\"id\":1,\"userName\":\"user1\",\"userAge\":25,\"userAccountId\":6767,\"userDepartmentId\":77896},{\"id\":2,\"userName\":\"user2\",\"userAge\":56,\"userAccountId\":556767,\"userDepartmentId\":89876}]";


        Mockito.when(userService.findAll()).thenReturn(records);
//        Mockito.doReturn(records).when(userService).findAll();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void getUser() throws Exception {
        String expected = "{\"id\":1,\"userName\":\"user1\",\"userAge\":25,\"userAccountId\":6767,\"userDepartmentId\":77896}";


        Mockito.when(userService.getById(1)).thenReturn(RECORD_1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void createUser() throws Exception {
        String expected = "{\"id\":1,\"userName\":\"user1\",\"userAge\":25,\"userAccountId\":6767,\"userDepartmentId\":77896}";


        Mockito.when(userRepository.save(RECORD_1)).thenReturn(RECORD_1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(RECORD_1));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

//        assertEquals("http://localhost:8080/user", response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void updateUser() throws Exception {
        String expected = "{\"id\":1,\"userName\":\"user1\",\"userAge\":25,\"userAccountId\":6767,\"userDepartmentId\":77896}";


        Mockito.when(userRepository.save(RECORD_1)).thenReturn(RECORD_1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(RECORD_1));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

//        assertEquals("http://localhost/user/1", response.getHeader(HttpHeaders.LOCATION));

    }

    @Test
    public void deleteUser() throws Exception {
        Mockito.when(userRepository.findById(RECORD_1.getId())).thenReturn(Optional.of(RECORD_1));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }





}
