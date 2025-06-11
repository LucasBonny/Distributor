package br.com.gunthercloud.distributor.resources;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.UUID;

import br.com.gunthercloud.distributor.services.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.gunthercloud.distributor.entities.dto.SupplierDTO;
import br.com.gunthercloud.distributor.services.SupplierService;
import br.com.gunthercloud.distributor.services.exceptions.DatabaseException;

@WebMvcTest(SupplierResource.class)
public class SupplierResourceTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SupplierService service;

    @Autowired
    private ObjectMapper objectMapper;

    private SupplierDTO supplierDTO;
    private List<SupplierDTO> supplierList;

    private UUID existingId;
    private UUID nonExistingId;

    @BeforeEach
    void setUp() throws Exception {
        existingId = UUID.fromString("550e8400-e29b-41d4-a716-446655440001");
        nonExistingId = UUID.fromString("550e8400-e29b-41d4-a716-446655440022");

        supplierDTO = Factory.createSupplierDTO();

        supplierList = List.of(supplierDTO);
        when(service.findAll()).thenReturn(supplierList);

        when(service.findById(existingId)).thenReturn(supplierDTO);
        when(service.findById(nonExistingId)).thenThrow(NotFoundException.class);

        when(service.create(any())).thenReturn(supplierDTO);

        when(service.update(eq(existingId), any())).thenReturn(supplierDTO);
        when(service.update(eq(nonExistingId), any())).thenThrow(NotFoundException.class);

        doThrow(DatabaseException.class).when(service).delete(any());
        doNothing().when(service).delete(existingId);
    }

    @Test
    void insertShouldReturnCreated() throws Exception {
        String json = objectMapper.writeValueAsString(supplierDTO);

        ResultActions result = mockMvc.perform(post("/suppliers")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated());
    }

    @Test
    void deleteShouldReturnNoContentWhenIdExists() throws Exception {
        mockMvc.perform(delete("/suppliers/{id}", existingId)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }

    @Test
    void updateShouldReturnSupplierDTOWhenIdExists() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(supplierDTO);

        mockMvc.perform(put("/suppliers/{id}", existingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    void updateShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(supplierDTO);

        mockMvc.perform(put("/suppliers/{id}", nonExistingId)
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    void findAllShouldReturnList() throws Exception {
        ResultActions result = mockMvc.perform(get("/suppliers")
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$").isArray());
        result.andExpect(jsonPath("$[0].id").exists());
    }

    @Test
    void findByIdShouldReturnSupplierDTO() throws Exception {
        ResultActions result = mockMvc.perform(get("/suppliers/{id}", existingId)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$.id").exists());
        result.andExpect(jsonPath("$.name").exists());
        result.andExpect(jsonPath("$.address").exists());
    }

    @Test
    void findByIdShouldReturnNotFoundWhenIdDoesNotExist() throws Exception {
        ResultActions result = mockMvc.perform(get("/suppliers/{id}", nonExistingId)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound());
        
    }
}
