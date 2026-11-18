# Architecture Index

## Implementation Guide

This index is not the full contract. Do not implement from this file alone; follow the listed artifact paths below.

### Global artifacts

- `unit_graph.yaml`
  - Who reads: all implementation workers.
  - Use for: current unit boundary, public signature, source anchor, and dependencies.
  - How to consume: filter `units` to the assigned unit and preserve its exported signature.
- `wire_contracts.yaml`
  - Who reads: workers adding or changing external interfaces.
  - Use for: currently observed external contracts.
  - How to consume: filter `contracts` by the assigned unit or `global`; the current list is empty because no application-level messaging or API code exists.
- `shared_modules.yaml`
  - Who reads: workers using code shared across implementation units.
  - Use for: modules referenced by multiple units.
  - How to consume: filter `modules` by `used_by_units`; there are no cross-unit shared modules identified yet.
- `cross_unit_state.yaml`
  - Who reads: workers handling state passed between units.
  - Use for: implicit state flows between units.
  - How to consume: filter flows by writer or reader unit; no such flows are currently implemented.

### Unit: `platform-info-api`

- External trigger: public Java API call to `PlatformInfo.getName()`; this is a library method, not an HTTP endpoint or running service.
- Must read:
  - `units/platform-info-api/behavior.yaml` — current side effects, branches, error paths, and execution model.
  - `units/platform-info-api/bindings.yaml` — framework bindings and runtime configuration; currently none.
  - `units/platform-info-api/unit_decomposition.yaml` — advisory split candidates only; `commit: false`.
- Relevant global rows:
  - `wire_contracts.yaml`: rows for `platform-info-api` or `global`.
  - `shared_modules.yaml`: rows whose `used_by_units` contains `platform-info-api`.
  - `cross_unit_state.yaml`: flows whose writer or reader is `platform-info-api`.
- Before DONE report: artifact paths read, preserved behavior, unresolved/deferred contracts, and build/test/runtime evidence.

