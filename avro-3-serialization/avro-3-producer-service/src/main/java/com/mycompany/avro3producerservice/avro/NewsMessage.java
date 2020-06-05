/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.mycompany.avro3producerservice.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class NewsMessage extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 6286163483370226683L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"NewsMessage\",\"namespace\":\"com.mycompany.avro3producerservice.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"fromId\",\"type\":\"int\"},{\"name\":\"fromName\",\"type\":\"string\"},{\"name\":\"title\",\"type\":\"string\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<NewsMessage> ENCODER =
      new BinaryMessageEncoder<NewsMessage>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<NewsMessage> DECODER =
      new BinaryMessageDecoder<NewsMessage>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<NewsMessage> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<NewsMessage> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<NewsMessage> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<NewsMessage>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this NewsMessage to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a NewsMessage from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a NewsMessage instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static NewsMessage fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence id;
  @Deprecated public int fromId;
  @Deprecated public java.lang.CharSequence fromName;
  @Deprecated public java.lang.CharSequence title;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public NewsMessage() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param fromId The new value for fromId
   * @param fromName The new value for fromName
   * @param title The new value for title
   */
  public NewsMessage(java.lang.CharSequence id, java.lang.Integer fromId, java.lang.CharSequence fromName, java.lang.CharSequence title) {
    this.id = id;
    this.fromId = fromId;
    this.fromName = fromName;
    this.title = title;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return fromId;
    case 2: return fromName;
    case 3: return title;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: fromId = (java.lang.Integer)value$; break;
    case 2: fromName = (java.lang.CharSequence)value$; break;
    case 3: title = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'fromId' field.
   * @return The value of the 'fromId' field.
   */
  public int getFromId() {
    return fromId;
  }


  /**
   * Sets the value of the 'fromId' field.
   * @param value the value to set.
   */
  public void setFromId(int value) {
    this.fromId = value;
  }

  /**
   * Gets the value of the 'fromName' field.
   * @return The value of the 'fromName' field.
   */
  public java.lang.CharSequence getFromName() {
    return fromName;
  }


  /**
   * Sets the value of the 'fromName' field.
   * @param value the value to set.
   */
  public void setFromName(java.lang.CharSequence value) {
    this.fromName = value;
  }

  /**
   * Gets the value of the 'title' field.
   * @return The value of the 'title' field.
   */
  public java.lang.CharSequence getTitle() {
    return title;
  }


  /**
   * Sets the value of the 'title' field.
   * @param value the value to set.
   */
  public void setTitle(java.lang.CharSequence value) {
    this.title = value;
  }

  /**
   * Creates a new NewsMessage RecordBuilder.
   * @return A new NewsMessage RecordBuilder
   */
  public static com.mycompany.avro3producerservice.avro.NewsMessage.Builder newBuilder() {
    return new com.mycompany.avro3producerservice.avro.NewsMessage.Builder();
  }

  /**
   * Creates a new NewsMessage RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new NewsMessage RecordBuilder
   */
  public static com.mycompany.avro3producerservice.avro.NewsMessage.Builder newBuilder(com.mycompany.avro3producerservice.avro.NewsMessage.Builder other) {
    if (other == null) {
      return new com.mycompany.avro3producerservice.avro.NewsMessage.Builder();
    } else {
      return new com.mycompany.avro3producerservice.avro.NewsMessage.Builder(other);
    }
  }

  /**
   * Creates a new NewsMessage RecordBuilder by copying an existing NewsMessage instance.
   * @param other The existing instance to copy.
   * @return A new NewsMessage RecordBuilder
   */
  public static com.mycompany.avro3producerservice.avro.NewsMessage.Builder newBuilder(com.mycompany.avro3producerservice.avro.NewsMessage other) {
    if (other == null) {
      return new com.mycompany.avro3producerservice.avro.NewsMessage.Builder();
    } else {
      return new com.mycompany.avro3producerservice.avro.NewsMessage.Builder(other);
    }
  }

  /**
   * RecordBuilder for NewsMessage instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<NewsMessage>
    implements org.apache.avro.data.RecordBuilder<NewsMessage> {

    private java.lang.CharSequence id;
    private int fromId;
    private java.lang.CharSequence fromName;
    private java.lang.CharSequence title;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.mycompany.avro3producerservice.avro.NewsMessage.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.fromId)) {
        this.fromId = data().deepCopy(fields()[1].schema(), other.fromId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.fromName)) {
        this.fromName = data().deepCopy(fields()[2].schema(), other.fromName);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.title)) {
        this.title = data().deepCopy(fields()[3].schema(), other.title);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
    }

    /**
     * Creates a Builder by copying an existing NewsMessage instance
     * @param other The existing instance to copy.
     */
    private Builder(com.mycompany.avro3producerservice.avro.NewsMessage other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.fromId)) {
        this.fromId = data().deepCopy(fields()[1].schema(), other.fromId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.fromName)) {
        this.fromName = data().deepCopy(fields()[2].schema(), other.fromName);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.title)) {
        this.title = data().deepCopy(fields()[3].schema(), other.title);
        fieldSetFlags()[3] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'fromId' field.
      * @return The value.
      */
    public int getFromId() {
      return fromId;
    }


    /**
      * Sets the value of the 'fromId' field.
      * @param value The value of 'fromId'.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder setFromId(int value) {
      validate(fields()[1], value);
      this.fromId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'fromId' field has been set.
      * @return True if the 'fromId' field has been set, false otherwise.
      */
    public boolean hasFromId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'fromId' field.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder clearFromId() {
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'fromName' field.
      * @return The value.
      */
    public java.lang.CharSequence getFromName() {
      return fromName;
    }


    /**
      * Sets the value of the 'fromName' field.
      * @param value The value of 'fromName'.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder setFromName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.fromName = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'fromName' field has been set.
      * @return True if the 'fromName' field has been set, false otherwise.
      */
    public boolean hasFromName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'fromName' field.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder clearFromName() {
      fromName = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'title' field.
      * @return The value.
      */
    public java.lang.CharSequence getTitle() {
      return title;
    }


    /**
      * Sets the value of the 'title' field.
      * @param value The value of 'title'.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder setTitle(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.title = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'title' field has been set.
      * @return True if the 'title' field has been set, false otherwise.
      */
    public boolean hasTitle() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'title' field.
      * @return This builder.
      */
    public com.mycompany.avro3producerservice.avro.NewsMessage.Builder clearTitle() {
      title = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public NewsMessage build() {
      try {
        NewsMessage record = new NewsMessage();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.fromId = fieldSetFlags()[1] ? this.fromId : (java.lang.Integer) defaultValue(fields()[1]);
        record.fromName = fieldSetFlags()[2] ? this.fromName : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.title = fieldSetFlags()[3] ? this.title : (java.lang.CharSequence) defaultValue(fields()[3]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<NewsMessage>
    WRITER$ = (org.apache.avro.io.DatumWriter<NewsMessage>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<NewsMessage>
    READER$ = (org.apache.avro.io.DatumReader<NewsMessage>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.id);

    out.writeInt(this.fromId);

    out.writeString(this.fromName);

    out.writeString(this.title);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);

      this.fromId = in.readInt();

      this.fromName = in.readString(this.fromName instanceof Utf8 ? (Utf8)this.fromName : null);

      this.title = in.readString(this.title instanceof Utf8 ? (Utf8)this.title : null);

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          break;

        case 1:
          this.fromId = in.readInt();
          break;

        case 2:
          this.fromName = in.readString(this.fromName instanceof Utf8 ? (Utf8)this.fromName : null);
          break;

        case 3:
          this.title = in.readString(this.title instanceof Utf8 ? (Utf8)this.title : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










