package lt.techin.exam.controller;

import lt.techin.exam.service.impl.SongFavoriteService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SongControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private SongFavoriteService songFavoriteService;

    @Captor
    private ArgumentCaptor<String> stringCaptor;

    @Test
    void deleteSong() throws Exception {
        mockMvc.perform(
                MockMvcRequestBuilders.get("")
        ).andExpectAll(
                status().isOk()
        );
    }





}