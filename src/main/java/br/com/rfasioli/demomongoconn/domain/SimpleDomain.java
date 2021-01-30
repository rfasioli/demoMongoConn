package br.com.rfasioli.demomongoconn.domain;

import javax.validation.constraints.NotNull;

import br.com.rfasioli.demomongoconn.domain.validators.IsValidSimpleDomain;

@IsValidSimpleDomain
public class SimpleDomain extends SelfValidating<SimpleDomain> {

    @NotNull(message = "O Id é obrigatório")
    private final Integer id;

    private final Integer value;

    private SimpleDomain(final Builder builder) { 
        this.id = builder.id;
        this.value = builder.value;
        super.validateSelf();
    } 
  
    public static Builder newBuilder() { 
        return new Builder(); 
    } 
  
    public Integer getId() {
      return this.id;
    }
    
    public Integer getValue() {
        return this.value;
    }    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SimpleDomain other = (SimpleDomain) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SimpleDomain [id=" + id + ", value=" + value + "]";
    }

    public static class Builder { 
        private Integer id;
        private Integer value;
    
        private Builder() { 
        } 
      
        public Builder withId(Integer id) { 
            this.id = id; 
            return this; 
        } 

        public Builder withValue(Integer value) { 
            this.value = value; 
            return this; 
        } 

        public SimpleDomain build() { 
            return new SimpleDomain(this); 
        } 
      }
  
  }