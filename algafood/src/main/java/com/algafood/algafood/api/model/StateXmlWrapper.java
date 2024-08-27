package com.algafood.algafood.api.model;

import com.algafood.algafood.domain.model.State;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@JacksonXmlRootElement(localName = "states")
@Data
public class StateXmlWrapper {

     @NonNull
    private List<State> states;
}
