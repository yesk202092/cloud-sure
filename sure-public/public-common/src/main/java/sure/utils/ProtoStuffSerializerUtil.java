package sure.utils;


import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ProtoStuffSerializerUtil {
    public ProtoStuffSerializerUtil() {
    }

    public static <T> byte[] serialize(T obj) {
        if (obj == null) {
            throw new RuntimeException("序列化对象(" + obj + ")!");
        } else {
            Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(obj.getClass());
            LinkedBuffer buffer = LinkedBuffer.allocate(1048576);
            Object var3 = null;

            byte[] protostuff;
            try {
                protostuff = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
            } catch (Exception var8) {
                throw new RuntimeException("序列化(" + obj.getClass() + ")对象(" + obj + ")发生异常!", var8);
            } finally {
                buffer.clear();
            }

            return protostuff;
        }
    }

    public static <T> T deserialize(byte[] paramArrayOfByte, Class<T> targetClass) {
        if (paramArrayOfByte != null && paramArrayOfByte.length != 0) {
            T instance = null;

            try {
                instance = targetClass.newInstance();
            } catch (IllegalAccessException | InstantiationException var4) {
                throw new RuntimeException("反序列化过程中依据类型创建对象失败!", var4);
            }

            Schema<T> schema = RuntimeSchema.getSchema(targetClass);
            ProtostuffIOUtil.mergeFrom(paramArrayOfByte, instance, schema);
            return instance;
        } else {
            throw new RuntimeException("反序列化对象发生异常,byte序列为空!");
        }
    }

    public static <T> byte[] serializeList(List<T> objList) {
        if (objList != null && !objList.isEmpty()) {
            Schema<T> schema = (Schema<T>) RuntimeSchema.getSchema(objList.get(0).getClass());
            LinkedBuffer buffer = LinkedBuffer.allocate(1048576);
            ByteArrayOutputStream bos = null;

            byte[] protostuff;
            try {
                bos = new ByteArrayOutputStream();
                ProtostuffIOUtil.writeListTo(bos, objList, schema, buffer);
                protostuff = bos.toByteArray();
            } catch (Exception var13) {
                throw new RuntimeException("序列化对象列表(" + objList + ")发生异常!", var13);
            } finally {
                buffer.clear();

                try {
                    if (bos != null) {
                        bos.close();
                    }
                } catch (IOException var12) {
                    var12.printStackTrace();
                }

            }

            return protostuff;
        } else {
            throw new RuntimeException("序列化对象列表(" + objList + ")参数异常!");
        }
    }

    public static <T> List<T> deserializeList(byte[] paramArrayOfByte, Class<T> targetClass) {
        if (paramArrayOfByte != null && paramArrayOfByte.length != 0) {
            Schema<T> schema = RuntimeSchema.getSchema(targetClass);
            List result = null;

            try {
                result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(paramArrayOfByte), schema);
                return result;
            } catch (IOException var5) {
                throw new RuntimeException("反序列化对象列表发生异常!", var5);
            }
        } else {
            throw new RuntimeException("反序列化对象发生异常,byte序列为空!");
        }
    }
}