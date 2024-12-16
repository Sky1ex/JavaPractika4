package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "picture")
@XmlAccessorType(XmlAccessType.FIELD)
public class Picture {

    @XmlElement(name = "large")
    private String large;
    @XmlElement(name = "medium")
    private String medium;
    @XmlElement(name = "thumbnail")
    private String thumbnail;
}
