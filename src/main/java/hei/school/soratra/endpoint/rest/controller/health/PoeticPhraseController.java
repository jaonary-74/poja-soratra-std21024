package hei.school.soratra.endpoint.rest.controller.health;

import hei.school.soratra.repository.model.PoeticPhrase;
import hei.school.soratra.service.event.PoeticPhraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PoeticPhraseController {
    @Autowired
    private PoeticPhraseService phraseService;

    @PutMapping("/soratra/{id}")
    public ResponseEntity<Void> createPoeticPhrase(@RequestBody PoeticPhrase phrase, @PathVariable String id) {
        phrase.setId(id);
        phraseService.savePhrase(phrase);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/soratra/{id}")
    public ResponseEntity<?> getPoeticPhrase(@PathVariable String id) {
        PoeticPhrase phrase = phraseService.getPhraseById(id);
        if (phrase == null) {
            return ResponseEntity.notFound().build();
        }

        String originalUrl = "https://original.url/" + phrase.getId();
        String transformedUrl = "https://transformed.url/" + phrase.getId();

        PoeticPhraseResponse response = new PoeticPhraseResponse(originalUrl, transformedUrl);
        return ResponseEntity.ok(response);
    }

    private static class PoeticPhraseResponse {
        private String original_url;
        private String transformed_url;

        public PoeticPhraseResponse(String original_url, String transformed_url) {
            this.original_url = original_url;
            this.transformed_url = transformed_url;
        }
    }
}