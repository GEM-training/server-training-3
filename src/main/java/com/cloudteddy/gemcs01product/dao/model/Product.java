package com.cloudteddy.gemcs01product.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.solr.analysis.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kimtung on 1/20/16.
 */
@Entity
@Table(name = "product",
        indexes = {@Index(name = "product_name_index", columnList = "name asc")})
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "product")
@Indexed
@AnalyzerDefs({
        @AnalyzerDef(name = "nGramAnalyzer",
                tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class),
                filters = {
                        @TokenFilterDef(factory = WordDelimiterFilterFactory.class),
                        @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                        @TokenFilterDef(factory = NGramFilterFactory.class, params = {
                                @Parameter(name = "minGramSize", value = "2"),
                                @Parameter(name = "maxGramSize", value = "5")
                        }),
                }
        ),
        @AnalyzerDef(name = "edgeAnalyzer",
        tokenizer = @TokenizerDef(factory = KeywordTokenizerFactory.class),
        filters = {
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = StopFilterFactory.class),
                @TokenFilterDef(factory = EdgeNGramFilterFactory.class, params = {
                        @Parameter(name = "minGramSize", value = "3"),
                        @Parameter(name = "maxGramSize", value = "50")})})
})
public class Product {

    @Id
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    @Column(name = "id", nullable = false, unique = true)
    @DocumentId
    @NotNull(message = "id not null")
    private long id;

    @Column(name = "name", nullable = false)
    @Fields({
            @Field(name = "name_ngram", analyzer = @Analyzer(definition = "nGramAnalyzer")),
            @Field(name = "name_edge", analyzer = @Analyzer(definition = "edgeAnalyzer"))
    })
    @Length(min = 1, max = 255, message = "name too long")
    @NotNull(message = "name not null")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    @NotNull(message = "type not null")
    private Type type;

    @org.hibernate.annotations.Type(type = "text")
    @Length(max = 2000, message = "detail too long")
    @Column(name = "detail", nullable = true)
    @Fields({
            @Field(name = "detail_ngram", analyzer = @Analyzer(definition = "nGramAnalyzer")),
            @Field(name = "detail_edge", analyzer = @Analyzer(definition = "edgeAnalyzer")),
    })
    private String detail;

    @OneToMany(mappedBy = "id.product", cascade = CascadeType.ALL)
    private Set<Bill.BillLine> billLines = new HashSet<>(0);

    @OneToMany(mappedBy = "id.product", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Inventory.ProductInInventory> inventories = new HashSet<>(0);

    @ManyToMany(mappedBy = "products")
    @JsonIgnore
    private Set<Promotion> promotions = new HashSet<>(0);

    @OneToMany(mappedBy = "id.product")
    @JsonIgnore
    private Set<Price> prices = new HashSet<>(0);

    public Product() {
    }

    public Product(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public Product(String name, String detail, Type type) {
        this.name = name;
        this.detail = detail;
        this.type = type;
    }

    public Product(Product product) {
        this.name = product.getName();
        this.detail = product.getDetail();
        this.type = product.getType();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Bill.BillLine> getBillLines() {
        return billLines;
    }

    public void setBillLines(Set<Bill.BillLine> billLines) {
        this.billLines = billLines;
    }

    public Set<Inventory.ProductInInventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<Inventory.ProductInInventory> inventories) {
        this.inventories = inventories;
    }

    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (type != null ? !type.equals(product.type) : product.type != null) return false;
        return detail != null ? detail.equals(product.detail) : product.detail == null;

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Entity
    @Table(name = "product_type")
    public static class Type {

        @Id
        @Column(name = "id", nullable = false, unique = true)
        @SequenceGenerator(name = "product_type_id_seq", sequenceName = "product_type_id_seq", initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_type_id_seq")
        private long id;

        @Column(name = "name", nullable = false, unique = true)
        private String name;

        @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
        @JsonIgnore
        private Set<Product> products;

        public Type(String name) {
            this.name = name;
        }

        public Type() {
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<Product> getProducts() {
            return products;
        }

        public void setProducts(Set<Product> products) {
            this.products = products;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Type type = (Type) o;

            if (id != type.id) return false;
            return name != null ? name.equals(type.name) : type.name == null;

        }

        @Override
        public String toString() {
            return "Type{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Entity
    @Table(name = "product_price")
    @AssociationOverrides({
            @AssociationOverride(name = "id.product", joinColumns = @JoinColumn(name = "product_id")),
            @AssociationOverride(name = "id.dealer", joinColumns = @JoinColumn(name = "dealer_id"))})
    public static class Price {

        @EmbeddedId
        private Id id;

        @Column(name = "price", nullable = true)
        private double price;

        @Embeddable
        public static class Id implements Serializable {

            @ManyToOne
            private Product product;

            @ManyToOne
            private Dealer dealer;
        }

    }
}
