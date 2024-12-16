package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
public class FullAddress
{
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "state")
    private String state;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "street")
    private String street;
    @XmlElement(name = "number")
    private int number;
}
