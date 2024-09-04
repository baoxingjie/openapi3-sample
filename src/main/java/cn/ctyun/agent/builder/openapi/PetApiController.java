package cn.ctyun.agent.builder.openapi;

import cn.ctyun.agent.builder.openapi.pet.api.PetApi;
import cn.ctyun.agent.builder.openapi.pet.model.PetVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class PetApiController implements PetApi {

    @Override
    public ResponseEntity<List<PetVO>> getAllPets() {
        PetVO petVO = mockPetVO();
        return ResponseEntity.of(Optional.of(List.of(petVO)));
    }

    @Override
    public ResponseEntity<PetVO> addPet(PetVO body) {
        // 创建一个包含状态码、响应头和主体的 ResponseEntity 对象
        return new ResponseEntity<>(mockPetVO(), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<PetVO> getPetById(Long id) {
        PetVO petVO = mockPetVO();
        return ResponseEntity.of(Optional.of(mockPetVO()));
    }

    @Override
    public ResponseEntity<PetVO> updatePet(Long id, PetVO body) {
        PetVO petVO = mockPetVO();
        // 创建一个包含状态码、响应头和主体的 ResponseEntity 对象
        return new ResponseEntity<>(petVO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deletePetById(Long id) {
        return ResponseEntity.noContent().build();
    }

//    @Override
//    public ResponseEntity<PetPageVO> getPage(Pageable pageable) {
//        return null;
//    }


    private static PetVO mockPetVO() {
        PetVO petVO = new PetVO();
        petVO.setId(1000001L);
        petVO.setName("test");
        petVO.setPrice(100.0);
        petVO.setShow(true);
        petVO.setType(1);
        petVO.setCreateTime(LocalDateTime.now());
        petVO.setPassword("test");
        return petVO;
    }
}
