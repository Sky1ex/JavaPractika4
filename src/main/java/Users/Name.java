package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@Getter
@AllArgsConstructor
@XmlRootElement(name = "Name")
@XmlAccessorType(XmlAccessType.FIELD)
public class Name {
    @XmlElement(name = "title")
    private String title;
    @XmlElement(name = "first")
    private String first;
    @XmlElement(name = "last")
    private String last;
}
