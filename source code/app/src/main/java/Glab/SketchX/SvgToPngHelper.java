package Glab.SketchX;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.caverock.androidsvg.SVG;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class SvgToPngHelper {
    public static void convertSvgFileToPng(File svgFile, File pngFile, int width, int height) throws Exception {
        FileInputStream fis = new FileInputStream(svgFile);
        SVG svg = SVG.getFromInputStream(fis);
        fis.close();

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        svg.renderToCanvas(canvas);

        FileOutputStream fos = new FileOutputStream(pngFile);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
        fos.flush();
        fos.close();
        bitmap.recycle();
    }
}
