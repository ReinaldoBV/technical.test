package com.azurian.technical.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * The Class TechnicalTestApplicationTests.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class TechnicalTestApplicationTests {

	/** The mock mvc. */
	@Autowired
	private MockMvc mockMvc;

	/** The person repository. */
	@Autowired
	private PersonRepository personRepository;

	/**
	 * Delete all before tests.
	 *
	 * @throws Exception the exception
	 */
	@BeforeEach
	public void deleteAllBeforeTests() throws Exception {
		personRepository.deleteAll();
	}

	/**
	 * Should return repository index.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldReturnRepositoryIndex() throws Exception {

		mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()).andExpect(
				jsonPath("$._links.people").exists());
	}

	/**
	 * Should create entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldCreateEntity() throws Exception {

		mockMvc.perform(post("/people").content(
				"{\"firstName\": \"Karly\", \"lastName\":\"Bustamante\"}")).andExpect(
						status().isCreated()).andExpect(
								header().string("Location", containsString("people/")));
	}

	/**
	 * Should retrieve entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldRetrieveEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/people").content(
				"{\"firstName\": \"Karly\", \"lastName\":\"Bustamante\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.firstName").value("Karly")).andExpect(
						jsonPath("$.lastName").value("Bustamante"));
	}

	/**
	 * Should query entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldQueryEntity() throws Exception {

		mockMvc.perform(post("/people").content(
				"{ \"firstName\": \"Karly\", \"lastName\":\"Bustamante\"}")).andExpect(
						status().isCreated());

		mockMvc.perform(
				get("/people/search/findByLastName?name={name}", "Bustamante")).andExpect(
						status().isOk()).andExpect(
								jsonPath("$._embedded.people[0].firstName").value(
										"Karly"));
	}

	/**
	 * Should update entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/people").content(
				"{\"firstName\": \"Karly\", \"lastName\":\"Bustamante\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(put(location).content(
				"{\"firstName\": \"Kristian\", \"lastName\":\"Garcia\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.firstName").value("Kristian")).andExpect(
						jsonPath("$.lastName").value("Garcia"));
	}

	/**
	 * Should partially update entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldPartiallyUpdateEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/people").content(
				"{\"firstName\": \"Karly\", \"lastName\":\"Bustamante\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");

		mockMvc.perform(
				patch(location).content("{\"firstName\": \"Miguel\"}")).andExpect(
						status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isOk()).andExpect(
				jsonPath("$.firstName").value("Miguel")).andExpect(
						jsonPath("$.lastName").value("Bustamante"));
	}

	/**
	 * Should delete entity.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void shouldDeleteEntity() throws Exception {

		MvcResult mvcResult = mockMvc.perform(post("/people").content(
				"{ \"firstName\": \"Karly\", \"lastName\":\"Bustamante\"}")).andExpect(
						status().isCreated()).andReturn();

		String location = mvcResult.getResponse().getHeader("Location");
		mockMvc.perform(delete(location)).andExpect(status().isNoContent());

		mockMvc.perform(get(location)).andExpect(status().isNotFound());
	}
}
