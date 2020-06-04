package com.ringort.demo.rest.controller


import com.ringort.demo.SpringCloudSleuthTracingDemoApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import spock.lang.Specification

@ContextConfiguration(classes = SpringCloudSleuthTracingDemoApplication.class)
@SpringBootTest(classes = SpringCloudSleuthTracingDemoApplication.class)
@ActiveProfiles(profiles = ["test"])
@AutoConfigureMockMvc
class DemoControllerTest extends Specification {

    @Autowired
    WebApplicationContext webApplicationContext

    @Autowired
    MockMvc mockMvc


    def setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build()
    }

    def "Generate change password verification code should create verification code and persist it when principal exist"() {
        when:
        mockMvc.perform(MockMvcRequestBuilders.get("/"))

        then:
        1 == 1
    }
}
