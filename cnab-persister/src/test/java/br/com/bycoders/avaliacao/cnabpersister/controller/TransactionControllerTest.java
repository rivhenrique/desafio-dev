package br.com.bycoders.avaliacao.cnabpersister.controller;

import br.com.bycoders.avaliacao.cnabpersister.dto.StoreTransactionsAndBalanceDTO;
import br.com.bycoders.avaliacao.cnabpersister.dto.StoresTransactionsResponseDTO;
import br.com.bycoders.avaliacao.cnabpersister.service.CnabFileService;
import br.com.bycoders.avaliacao.cnabpersister.service.TransactionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private CnabFileService cnabFileService;

    @Test
    public void testControllerLayerGetStoreReport() throws Exception {
        when(transactionService.detailStoreTransactions()).thenReturn(getResponseObject());

        RequestBuilder builder = MockMvcRequestBuilders
                .get("/transaction/stores/report")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(builder).andReturn();

        String expected = "{\"storesDetails\":[{\"storeName\":\"Teste loja\",\"balance\":0,\"transactionList\":[]}]}";
        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void testControllerLayerPostCnabFileUpload() throws Exception {
        doNothing().when(cnabFileService).processFile(Mockito.any(MultipartFile.class));

        RequestBuilder builder = MockMvcRequestBuilders
                .multipart("/transaction/cnab-file/upload")
                .file(getMockMultipartFile());

        MvcResult result = mockMvc.perform(builder).andReturn();
        String expected = "Upload e processamento do arquivo realizado com sucesso! Para ver a lista completa clique no link: \n" +
                "<a href=\"http://localhost:8080/cnab-persister/transaction/stores/report\">Listar Transações</a>\n";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    @Test
    public void testControllerLayerPostCnabFileUploadFailed() throws Exception {
        doNothing().when(cnabFileService).processFile(Mockito.any(MultipartFile.class));

        RequestBuilder builder = MockMvcRequestBuilders
                .multipart("/transaction/cnab-file/upload")
                .file(getMockMultipartFileEmpty());

        MvcResult result = mockMvc.perform(builder).andReturn();
        String expected = "Arquivo falhou ao ser enviado!!";

        assertEquals(expected, result.getResponse().getContentAsString());
    }

    private StoresTransactionsResponseDTO getResponseObject() {
        StoresTransactionsResponseDTO dto = new StoresTransactionsResponseDTO();
        dto.setStoresDetails(new ArrayList<>());
        dto.getStoresDetails().add(new StoreTransactionsAndBalanceDTO("Teste loja", BigDecimal.ZERO, new ArrayList<>()));
        return dto;
    }

    private MockMultipartFile getMockMultipartFile() {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "file.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "3201903010000014200096206760174753****3153153453JOÃO MACEDO   BAR DO JOÃO       ".getBytes()
        );
        return file;
    }

    private MockMultipartFile getMockMultipartFileEmpty() {
        MockMultipartFile file = new MockMultipartFile(
                "file",
                "file.txt",
                MediaType.TEXT_PLAIN_VALUE,
                "".getBytes()
        );
        return file;
    }
}
