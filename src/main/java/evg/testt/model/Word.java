package evg.testt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "word")
public class Word extends BaseModel
{
    private String name;

    @OneToMany( mappedBy = "word", cascade = CascadeType.REMOVE)
    private Set<Description> descriptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(Set<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public static Builder newBuilder() {
        return new Word().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            Word.this.setId(id);
            return this;
        }

        public Builder setName(String name) {
            Word.this.name = name;

            return this;
        }

        public Word build() {
            return Word.this;
        }
    }
}
