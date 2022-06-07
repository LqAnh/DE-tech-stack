/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.bigdatums.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Person extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -7739165533853941223L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Person\",\"namespace\":\"com.bigdatums.avro\",\"fields\":[{\"name\":\"id\",\"type\":\"int\"},{\"name\":\"username\",\"type\":[\"string\",\"null\"]},{\"name\":\"email_address\",\"type\":[\"string\",\"null\"]},{\"name\":\"phone_number\",\"type\":[\"string\",\"null\"]},{\"name\":\"sex\",\"type\":[\"string\",\"null\"]},{\"name\":\"address\",\"type\":{\"type\":\"record\",\"name\":\"Address\",\"fields\":[{\"name\":\"streetaddress\",\"type\":\"string\"},{\"name\":\"city\",\"type\":\"string\"}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Person> ENCODER =
      new BinaryMessageEncoder<Person>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Person> DECODER =
      new BinaryMessageDecoder<Person>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Person> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Person> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Person> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Person>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Person to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Person from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Person instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Person fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private int id;
  private java.lang.CharSequence username;
  private java.lang.CharSequence email_address;
  private java.lang.CharSequence phone_number;
  private java.lang.CharSequence sex;
  private com.bigdatums.avro.Address address;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Person() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param username The new value for username
   * @param email_address The new value for email_address
   * @param phone_number The new value for phone_number
   * @param sex The new value for sex
   * @param address The new value for address
   */
  public Person(java.lang.Integer id, java.lang.CharSequence username, java.lang.CharSequence email_address, java.lang.CharSequence phone_number, java.lang.CharSequence sex, com.bigdatums.avro.Address address) {
    this.id = id;
    this.username = username;
    this.email_address = email_address;
    this.phone_number = phone_number;
    this.sex = sex;
    this.address = address;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return username;
    case 2: return email_address;
    case 3: return phone_number;
    case 4: return sex;
    case 5: return address;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.Integer)value$; break;
    case 1: username = (java.lang.CharSequence)value$; break;
    case 2: email_address = (java.lang.CharSequence)value$; break;
    case 3: phone_number = (java.lang.CharSequence)value$; break;
    case 4: sex = (java.lang.CharSequence)value$; break;
    case 5: address = (com.bigdatums.avro.Address)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public int getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(int value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'username' field.
   * @return The value of the 'username' field.
   */
  public java.lang.CharSequence getUsername() {
    return username;
  }


  /**
   * Sets the value of the 'username' field.
   * @param value the value to set.
   */
  public void setUsername(java.lang.CharSequence value) {
    this.username = value;
  }

  /**
   * Gets the value of the 'email_address' field.
   * @return The value of the 'email_address' field.
   */
  public java.lang.CharSequence getEmailAddress() {
    return email_address;
  }


  /**
   * Sets the value of the 'email_address' field.
   * @param value the value to set.
   */
  public void setEmailAddress(java.lang.CharSequence value) {
    this.email_address = value;
  }

  /**
   * Gets the value of the 'phone_number' field.
   * @return The value of the 'phone_number' field.
   */
  public java.lang.CharSequence getPhoneNumber() {
    return phone_number;
  }


  /**
   * Sets the value of the 'phone_number' field.
   * @param value the value to set.
   */
  public void setPhoneNumber(java.lang.CharSequence value) {
    this.phone_number = value;
  }

  /**
   * Gets the value of the 'sex' field.
   * @return The value of the 'sex' field.
   */
  public java.lang.CharSequence getSex() {
    return sex;
  }


  /**
   * Sets the value of the 'sex' field.
   * @param value the value to set.
   */
  public void setSex(java.lang.CharSequence value) {
    this.sex = value;
  }

  /**
   * Gets the value of the 'address' field.
   * @return The value of the 'address' field.
   */
  public com.bigdatums.avro.Address getAddress() {
    return address;
  }


  /**
   * Sets the value of the 'address' field.
   * @param value the value to set.
   */
  public void setAddress(com.bigdatums.avro.Address value) {
    this.address = value;
  }

  /**
   * Creates a new Person RecordBuilder.
   * @return A new Person RecordBuilder
   */
  public static com.bigdatums.avro.Person.Builder newBuilder() {
    return new com.bigdatums.avro.Person.Builder();
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Person RecordBuilder
   */
  public static com.bigdatums.avro.Person.Builder newBuilder(com.bigdatums.avro.Person.Builder other) {
    if (other == null) {
      return new com.bigdatums.avro.Person.Builder();
    } else {
      return new com.bigdatums.avro.Person.Builder(other);
    }
  }

  /**
   * Creates a new Person RecordBuilder by copying an existing Person instance.
   * @param other The existing instance to copy.
   * @return A new Person RecordBuilder
   */
  public static com.bigdatums.avro.Person.Builder newBuilder(com.bigdatums.avro.Person other) {
    if (other == null) {
      return new com.bigdatums.avro.Person.Builder();
    } else {
      return new com.bigdatums.avro.Person.Builder(other);
    }
  }

  /**
   * RecordBuilder for Person instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Person>
    implements org.apache.avro.data.RecordBuilder<Person> {

    private int id;
    private java.lang.CharSequence username;
    private java.lang.CharSequence email_address;
    private java.lang.CharSequence phone_number;
    private java.lang.CharSequence sex;
    private com.bigdatums.avro.Address address;
    private com.bigdatums.avro.Address.Builder addressBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.bigdatums.avro.Person.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.username)) {
        this.username = data().deepCopy(fields()[1].schema(), other.username);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.email_address)) {
        this.email_address = data().deepCopy(fields()[2].schema(), other.email_address);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.phone_number)) {
        this.phone_number = data().deepCopy(fields()[3].schema(), other.phone_number);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.sex)) {
        this.sex = data().deepCopy(fields()[4].schema(), other.sex);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.address)) {
        this.address = data().deepCopy(fields()[5].schema(), other.address);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (other.hasAddressBuilder()) {
        this.addressBuilder = com.bigdatums.avro.Address.newBuilder(other.getAddressBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing Person instance
     * @param other The existing instance to copy.
     */
    private Builder(com.bigdatums.avro.Person other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.username)) {
        this.username = data().deepCopy(fields()[1].schema(), other.username);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.email_address)) {
        this.email_address = data().deepCopy(fields()[2].schema(), other.email_address);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.phone_number)) {
        this.phone_number = data().deepCopy(fields()[3].schema(), other.phone_number);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.sex)) {
        this.sex = data().deepCopy(fields()[4].schema(), other.sex);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.address)) {
        this.address = data().deepCopy(fields()[5].schema(), other.address);
        fieldSetFlags()[5] = true;
      }
      this.addressBuilder = null;
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public int getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder setId(int value) {
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
    public com.bigdatums.avro.Person.Builder clearId() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'username' field.
      * @return The value.
      */
    public java.lang.CharSequence getUsername() {
      return username;
    }


    /**
      * Sets the value of the 'username' field.
      * @param value The value of 'username'.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder setUsername(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.username = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'username' field has been set.
      * @return True if the 'username' field has been set, false otherwise.
      */
    public boolean hasUsername() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'username' field.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder clearUsername() {
      username = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'email_address' field.
      * @return The value.
      */
    public java.lang.CharSequence getEmailAddress() {
      return email_address;
    }


    /**
      * Sets the value of the 'email_address' field.
      * @param value The value of 'email_address'.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder setEmailAddress(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.email_address = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'email_address' field has been set.
      * @return True if the 'email_address' field has been set, false otherwise.
      */
    public boolean hasEmailAddress() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'email_address' field.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder clearEmailAddress() {
      email_address = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'phone_number' field.
      * @return The value.
      */
    public java.lang.CharSequence getPhoneNumber() {
      return phone_number;
    }


    /**
      * Sets the value of the 'phone_number' field.
      * @param value The value of 'phone_number'.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder setPhoneNumber(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.phone_number = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'phone_number' field has been set.
      * @return True if the 'phone_number' field has been set, false otherwise.
      */
    public boolean hasPhoneNumber() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'phone_number' field.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder clearPhoneNumber() {
      phone_number = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'sex' field.
      * @return The value.
      */
    public java.lang.CharSequence getSex() {
      return sex;
    }


    /**
      * Sets the value of the 'sex' field.
      * @param value The value of 'sex'.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder setSex(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.sex = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'sex' field has been set.
      * @return True if the 'sex' field has been set, false otherwise.
      */
    public boolean hasSex() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'sex' field.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder clearSex() {
      sex = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'address' field.
      * @return The value.
      */
    public com.bigdatums.avro.Address getAddress() {
      return address;
    }


    /**
      * Sets the value of the 'address' field.
      * @param value The value of 'address'.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder setAddress(com.bigdatums.avro.Address value) {
      validate(fields()[5], value);
      this.addressBuilder = null;
      this.address = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'address' field has been set.
      * @return True if the 'address' field has been set, false otherwise.
      */
    public boolean hasAddress() {
      return fieldSetFlags()[5];
    }

    /**
     * Gets the Builder instance for the 'address' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.bigdatums.avro.Address.Builder getAddressBuilder() {
      if (addressBuilder == null) {
        if (hasAddress()) {
          setAddressBuilder(com.bigdatums.avro.Address.newBuilder(address));
        } else {
          setAddressBuilder(com.bigdatums.avro.Address.newBuilder());
        }
      }
      return addressBuilder;
    }

    /**
     * Sets the Builder instance for the 'address' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.bigdatums.avro.Person.Builder setAddressBuilder(com.bigdatums.avro.Address.Builder value) {
      clearAddress();
      addressBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'address' field has an active Builder instance
     * @return True if the 'address' field has an active Builder instance
     */
    public boolean hasAddressBuilder() {
      return addressBuilder != null;
    }

    /**
      * Clears the value of the 'address' field.
      * @return This builder.
      */
    public com.bigdatums.avro.Person.Builder clearAddress() {
      address = null;
      addressBuilder = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Person build() {
      try {
        Person record = new Person();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.Integer) defaultValue(fields()[0]);
        record.username = fieldSetFlags()[1] ? this.username : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.email_address = fieldSetFlags()[2] ? this.email_address : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.phone_number = fieldSetFlags()[3] ? this.phone_number : (java.lang.CharSequence) defaultValue(fields()[3]);
        record.sex = fieldSetFlags()[4] ? this.sex : (java.lang.CharSequence) defaultValue(fields()[4]);
        if (addressBuilder != null) {
          try {
            record.address = this.addressBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("address"));
            throw e;
          }
        } else {
          record.address = fieldSetFlags()[5] ? this.address : (com.bigdatums.avro.Address) defaultValue(fields()[5]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Person>
    WRITER$ = (org.apache.avro.io.DatumWriter<Person>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Person>
    READER$ = (org.apache.avro.io.DatumReader<Person>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.id);

    if (this.username == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeString(this.username);
    }

    if (this.email_address == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeString(this.email_address);
    }

    if (this.phone_number == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeString(this.phone_number);
    }

    if (this.sex == null) {
      out.writeIndex(1);
      out.writeNull();
    } else {
      out.writeIndex(0);
      out.writeString(this.sex);
    }

    this.address.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.id = in.readInt();

      if (in.readIndex() != 0) {
        in.readNull();
        this.username = null;
      } else {
        this.username = in.readString(this.username instanceof Utf8 ? (Utf8)this.username : null);
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.email_address = null;
      } else {
        this.email_address = in.readString(this.email_address instanceof Utf8 ? (Utf8)this.email_address : null);
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.phone_number = null;
      } else {
        this.phone_number = in.readString(this.phone_number instanceof Utf8 ? (Utf8)this.phone_number : null);
      }

      if (in.readIndex() != 0) {
        in.readNull();
        this.sex = null;
      } else {
        this.sex = in.readString(this.sex instanceof Utf8 ? (Utf8)this.sex : null);
      }

      if (this.address == null) {
        this.address = new com.bigdatums.avro.Address();
      }
      this.address.customDecode(in);

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.id = in.readInt();
          break;

        case 1:
          if (in.readIndex() != 0) {
            in.readNull();
            this.username = null;
          } else {
            this.username = in.readString(this.username instanceof Utf8 ? (Utf8)this.username : null);
          }
          break;

        case 2:
          if (in.readIndex() != 0) {
            in.readNull();
            this.email_address = null;
          } else {
            this.email_address = in.readString(this.email_address instanceof Utf8 ? (Utf8)this.email_address : null);
          }
          break;

        case 3:
          if (in.readIndex() != 0) {
            in.readNull();
            this.phone_number = null;
          } else {
            this.phone_number = in.readString(this.phone_number instanceof Utf8 ? (Utf8)this.phone_number : null);
          }
          break;

        case 4:
          if (in.readIndex() != 0) {
            in.readNull();
            this.sex = null;
          } else {
            this.sex = in.readString(this.sex instanceof Utf8 ? (Utf8)this.sex : null);
          }
          break;

        case 5:
          if (this.address == null) {
            this.address = new com.bigdatums.avro.Address();
          }
          this.address.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










