package kodlamaio.hrmsdemo.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrmsdemo.core.utilities.cloudinary.CloudinaryManager;
import kodlamaio.hrmsdemo.core.utilities.cloudinary.CloudinaryService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConf {
    @Value("${cld.access-key}")
    String apiKey;

    @Value("${cld.secret-key}")
    String apiSecretKey;

    @Bean
    public Cloudinary cloudinaryUser(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "kodlamaiohrmsproject",
                "api_key", apiKey,
                "api_secret", apiSecretKey));
    }

    @Bean
    public CloudinaryService cloudinaryService(){
        return new CloudinaryManager(cloudinaryUser());
    }

}
