package com.userapplication.user.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.userapplication.user.application.bean.Department;
import com.userapplication.user.application.bean.User;
import com.userapplication.user.application.controller.UserController;
import com.userapplication.user.application.repository.UserRepository;
import com.userapplication.user.application.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.any;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

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


    User user1 = new User(1, "user1", 25, 6767, 77896);
    User user2 = new User(2, "user2", 56, 556767, 89876);

    @Test
    public void getAllUser() throws Exception {
        List<User> records = new ArrayList<>(Arrays.asList(user1, user2));
        String expected = "[{\"id\":1,\"userName\":\"user1\",\"userAge\":25,\"userAccountId\":6767,\"userDepartmentId\":77896},{\"id\":2,\"userName\":\"user2\",\"userAge\":56,\"userAccountId\":556767,\"userDepartmentId\":89876}]";

        Mockito.when(userService.findAll()).thenReturn(records);

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

        Mockito.when(userService.getById(1)).thenReturn(user1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();


        System.out.println(expected);
        System.out.println(result.getResponse().getContentAsString());
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void createUser() throws Exception {
        String expected = "User{id=1, userName='user1', userAge=25, userAccountId=6767, userDepartmentId=77896}";


        MockitoAnnotations.openMocks(this);
        ArgumentCaptor<User> valueCapture = ArgumentCaptor.forClass(User.class);
        doNothing().when(userService).save(valueCapture.capture());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user1));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expected, valueCapture.getValue().toString());

    }

    @Test
    public void updateUser() throws Exception {
//        String expected = "{\"id\":1,\"userName\":\"user1\",\"userAge\":25,\"userAccountId\":6767,\"userDepartmentId\":77896}";
        String expected = "User{id=1, userName='user1', userAge=25, userAccountId=6767, userDepartmentId=77896}";

        MockitoAnnotations.openMocks(this);
        ArgumentCaptor<User> valueCapture = ArgumentCaptor.forClass(User.class);
        ArgumentCaptor<Long> valueCapture2 = ArgumentCaptor.forClass(long.class);
        doNothing().when(userService).modify(valueCapture2.capture(),valueCapture.capture());


        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/user/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(user1));

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(expected,valueCapture.getValue().toString());
        assertEquals(1,valueCapture2.getValue());

//        System.out.println(valueCapture.getValue());
//        verify(userService).modify(1,user1);


    }

    @Test
    public void deleteUser() throws Exception {
        MockitoAnnotations.openMocks(this);
        ArgumentCaptor<Long> valueCapture = ArgumentCaptor.forClass(long.class);
        doNothing().when(userService).deleteById(valueCapture.capture());

//        Mockito.when(userRepository.findById(user1.getId())).thenReturn(Optional.of(user1));

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/user/1")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals(1,valueCapture.getValue());

    }


    @Test
    void getUserAge() throws Exception {
//        String expected = "{\"id\":1,\"userName\":\"user1\",\"userAge\":25,\"userAccountId\":6767,\"userDepartmentId\":77896}";
        long expected = 25;

        Mockito.when(userService.getById(1)).thenReturn(user1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/user/1/age")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        assertEquals("25", result.getResponse().getContentAsString());
    }



}
