package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "location")
@XmlSeeAlso({Street.class, Coordinates.class, Timezone.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class Location
{
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "state")
    private String state;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "postcode")
    private String postcode;
    @XmlElement(name = "street")
    private Street street;
    @XmlElement(name = "coordinates")
    private Coordinates coordinates;
    @XmlElement(name = "timezone")
    private Timezone timezone;
}
