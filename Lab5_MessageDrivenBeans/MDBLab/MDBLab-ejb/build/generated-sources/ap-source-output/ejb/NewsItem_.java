package ejb;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-12T00:32:40", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(NewsItem.class)
public class NewsItem_ { 

    public static volatile SingularAttribute<NewsItem, String> heading;
    public static volatile SingularAttribute<NewsItem, Long> id;
    public static volatile SingularAttribute<NewsItem, String> body;

}