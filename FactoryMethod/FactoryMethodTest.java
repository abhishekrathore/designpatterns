interface ImageReader {
    DecodedImage getDecodeImage();
}


interface DecodedImage {
   String toString();
}

class GIFImage implements DecodedImage {
    private String image;

    public GIFImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return image + ": is GIF";
    }
}

class JPEGImage implements DecodedImage {
    private String image;

    public JPEGImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return image + ": is JPEG";
    }
}

class GifReader implements ImageReader {
    private DecodedImage decodedImage;

    public GifReader(String image) {
        this.decodedImage = new GIFImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

class JpegReader implements ImageReader {
    private DecodedImage decodedImage;

    public JpegReader(String image) {
        decodedImage = new JPEGImage(image);
    }

    @Override
    public DecodedImage getDecodeImage() {
        return decodedImage;
    }
}

public class FactoryMethodTest {
    public static void main(String[] args) {
        DecodedImage decodedImage;
        ImageReader reader = null;
        String image = args[0];
        String format = image.substring(image.indexOf('.') + 1, (image.length()));
        if (format.equals("gif")) {
            reader = new GifReader(image);
        }
        if (format.equals("jpeg")) {
            reader = new JpegReader(image);
        }
        assert reader != null;
        decodedImage = reader.getDecodeImage();
        System.out.println(decodedImage);
    }
}