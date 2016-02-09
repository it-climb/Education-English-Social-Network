package evg.testt.model;

import javax.persistence.*;

@Entity(name = "description")
public class Description extends BaseModel {
    private String name;
    @ManyToOne
    @JoinColumn(name = "wordId")
    private Word word;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public static Builder newBuilder() {
        return new Description().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            Description.this.id = id;
            return this;
        }

        public Builder setName(String name) {
            Description.this.name = name;
            return this;
        }


        public Builder setWord(Word word) {
            Description.this.word = word;
            return this;
        }

        public Description build() {
            return Description.this;
        }
    }
}
