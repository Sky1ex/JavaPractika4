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
@XmlSeeAlso({FullUser.class, FullAddress.class})
@XmlAccessorType(XmlAccessType.FIELD)
public class FullResults
{
    @XmlElement(name = "userArray")
    private ArrayList<FullUser> users;
}
