package br.ueg.prog.webi.faculdade.crud.controller;

import br.ueg.prog.webi.api.exception.MessageResponse;
import br.ueg.prog.webi.faculdade.crud.model.Imagem;
import br.ueg.prog.webi.faculdade.crud.service.impl.ImagemServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(path = "/imagem")
public class ImagemController {

    @Autowired
    private ImagemServiceImpl service;

    @Operation(
            description = "upload de imagem",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Media geral do Jogo",
                    content = {@Content(
                            mediaType = "application/json"
                    )}
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, path = "/upload")
    public ResponseEntity<?> uploadImagem(@RequestParam MultipartFile imagemASalvar) {
        if (imagemASalvar.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a file to upload.");
        }

        try {
            byte[] bytes = imagemASalvar.getBytes();
            Imagem img = new Imagem();
            img.setImg(bytes);
            img = service.incluir(img);
            return ResponseEntity.status(HttpStatus.OK).body(img);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File could not be uploaded");
        }
    }

//    @GetMapping
//    public Imagem obterPeloID(Long requestID){
//        return this.service.obterPeloId(requestID);
//    }


    @DeleteMapping
    public Imagem excluirFoto(Long id){return this.service.excluir(id);}

    @CrossOrigin(origins = "*")
    @Operation(
            description = "upload de imagem",
            responses = {@ApiResponse(
                    responseCode = "200",
                    description = "Media geral da imagem"
            ), @ApiResponse(
                    responseCode = "404",
                    description = "Registro não encontrado",
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = MessageResponse.class
                            )
                    )}
            )})
    @RequestMapping(value = "/{imageId}", method = RequestMethod.GET)
    public ResponseEntity getImage(@PathVariable("imageId") Long id) {
        Imagem img = service.obterPeloId(id);
        if (img == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/*").body(img.getImg());
    }
}
