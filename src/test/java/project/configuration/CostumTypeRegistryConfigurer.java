package project.configuration;

import cucumber.api.TypeRegistry;
import cucumber.runtime.DefaultTypeRegistryConfiguration;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;
import project.data.CineplexPageData;

import java.util.Locale;

public class CostumTypeRegistryConfigurer extends DefaultTypeRegistryConfiguration {
    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(defineCineplexMovieSpecifications());

    }

    public DataTableType defineCineplexMovieSpecifications() {
        return new DataTableType(CineplexPageData.class,
                (TableEntryTransformer<CineplexPageData>) dataRow -> {

            CineplexPageData cineplexPageData = new CineplexPageData();

                    cineplexPageData.setSpecificationTitle(dataRow.get("specificationTitle"));
                    cineplexPageData.setSpecification(dataRow.get("specification"));

                    return cineplexPageData;
                });
    }
}