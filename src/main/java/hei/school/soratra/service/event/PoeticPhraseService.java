package hei.school.soratra.service.event;

import hei.school.soratra.repository.PoeticPhraseRepository;
import hei.school.soratra.repository.model.PoeticPhrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PoeticPhraseService {
    @Autowired
    private PoeticPhraseRepository phraseRepository;

    public void savePhrase(PoeticPhrase phrase) {
        phraseRepository.save(phrase);
    }

    public PoeticPhrase getPhraseById(String id) {
        return phraseRepository.findById(id).orElse(null);
    }
}
