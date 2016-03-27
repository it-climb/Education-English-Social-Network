package evg.testt.dto;

import evg.testt.model.SubjectDifficult;
import evg.testt.model.activities.ActivityType;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by oleg on 27.03.16.
 */
public class ActivitySearchFilterDTO {
    private Pageable pageRequest;
    private String searchPhrase;
    private List<Integer> subjectIDs;
    private List<String> targetAges;
    private List<SubjectDifficult> difficultLevels;
    private List<ActivityType> types;


    public Pageable getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(Pageable pageRequest) {
        this.pageRequest = pageRequest;
    }

    public String getSearchPhrase() {
        return searchPhrase;
    }

    public void setSearchPhrase(String searchPhrase) {
        this.searchPhrase = searchPhrase;
    }

    public List<Integer> getSubjectIDs() {
        return subjectIDs;
    }

    public void setSubjectIDs(List<Integer> subjectIDs) {
        this.subjectIDs = subjectIDs;
    }

    public List<String> getTargetAges() {
        return targetAges;
    }

    public void setTargetAges(List<String> targetAges) {
        this.targetAges = targetAges;
    }

    public List<SubjectDifficult> getDifficultLevels() {
        return difficultLevels;
    }

    public void setDifficultLevels(List<SubjectDifficult> difficultLevels) {
        this.difficultLevels = difficultLevels;
    }

    public List<ActivityType> getTypes() {
        return types;
    }

    public void setTypes(List<ActivityType> types) {
        this.types = types;
    }

}
