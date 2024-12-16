package Users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "results")
@XmlSeeAlso(User.class)
@XmlAccessorType(XmlAccessType.FIELD)
public class Results
{
    @XmlElement(name = "user")
    private ArrayList<User> users;
}
