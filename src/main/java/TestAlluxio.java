import alluxio.AlluxioURI;
import alluxio.ClientContext;
import alluxio.client.file.FileInStream;
import alluxio.client.file.FileOutStream;
import alluxio.client.file.FileSystem;
import alluxio.conf.AlluxioConfiguration;
import alluxio.conf.AlluxioProperties;
import alluxio.conf.InstancedConfiguration;
import alluxio.conf.PropertyKey;
import org.apache.commons.io.IOUtils;


import java.io.FileOutputStream;

public class TestAlluxio {

    public static void main(String[] args) throws Exception{

//        AlluxioProperties properties = new AlluxioProperties();
//        properties.set(PropertyKey.MASTER_HOSTNAME,"3.89.38.106");
//
//        AlluxioConfiguration configuration = new InstancedConfiguration(properties);
//        ((InstancedConfiguration) configuration).set(PropertyKey.MASTER_HOSTNAME,"3.89.38.106");
//        ClientContext.create(configuration);
        FileSystem fs = FileSystem.Factory.get();
        AlluxioURI path = new AlluxioURI("/UserSpace/1-3/unet_membrane.hdf5");

        FileInStream in = fs.openFile(path);

        FileOutputStream fileOutputStream = new FileOutputStream("/root/unet_membrane.hdf5");
        fileOutputStream.write(IOUtils.toByteArray(in));
        in.close();
        fileOutputStream.close();

    }

}
