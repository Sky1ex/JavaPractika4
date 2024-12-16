package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "user")
@XmlSeeAlso({Name.class, Location.class, Picture.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class User
{
    @XmlElement(name = "name")
    private Name name;
    @XmlElement(name = "location")
    private Location location;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "phone")
    private String phone;
    @XmlElement(name = "picture")
    private Picture picture;
}
