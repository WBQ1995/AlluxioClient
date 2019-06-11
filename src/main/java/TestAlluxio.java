import alluxio.AlluxioURI;
import alluxio.ClientContext;
import alluxio.client.file.FileSystem;
import alluxio.conf.AlluxioConfiguration;
import alluxio.conf.AlluxioProperties;
import alluxio.conf.InstancedConfiguration;
import alluxio.conf.PropertyKey;

public class TestAlluxio {

    public static void main(String[] args) throws Exception{

        AlluxioProperties properties = new AlluxioProperties();
        properties.set(PropertyKey.MASTER_HOSTNAME,"3.89.38.106");

        AlluxioConfiguration configuration = new InstancedConfiguration(properties);
        ((InstancedConfiguration) configuration).set(PropertyKey.MASTER_HOSTNAME,"3.89.38.106");
        ClientContext.create(configuration);
        FileSystem fs = FileSystem.Factory.get();
        AlluxioURI path = new AlluxioURI("/Staging");
        fs.createFile(path);

    }

}
