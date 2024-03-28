import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.netology.springbootdemo.profiles.DevProfile;
import ru.netology.springbootdemo.profiles.ProductionProfile;
import ru.netology.springbootdemo.profiles.SystemProfile;

@Bean(name="profile")
@ConditionalOnProperty(name="profile", havingValue="true")
public SystemProfile devProfile() {
    return new DevProfile();
}

@Bean(name="profile")
@ConditionalOnProperty(name="profile", havingValue="false")
public SystemProfile prodProfile() {
    return new ProductionProfile();
}

//@ConfigurationProperties("profile")
public void main() {
}
